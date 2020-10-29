// Reference for Lanterna 3: https://github.com/mabe02/lanterna/blob/master/docs/contents.md
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.util.Scanner;

public class ConwaysLife {
    public static void main(String[] args) {
        try {

            Terminal terminal = new DefaultTerminalFactory().createTerminal();


            Screen screen = new TerminalScreen(terminal);

            screen.refresh();
            TextGraphics graphics = screen.newTextGraphics();
            TerminalSize size = screen.getTerminalSize();
            LifeSimulator simulation = new LifeSimulator(size.getColumns(), size.getRows());
            Pattern pattern = new PatternBlock();
            //Pattern pattern = new PatternBlinker();
            //Pattern pattern = new PatternAcorn();
            // Pattern pattern = new PatternGlider();
            //Pattern pattern = new GosperGlider();



            simulation.insertPattern(pattern, 1, 1);
            screen.startScreen();
            screen.setCursorPosition(null);

            for (int i = 0; i < 500; i++) {
                render(simulation, screen, graphics); // Render the current state of the simulation
                //sampleRender(screen, graphics, i);
                Thread.yield(); // Let the JVM have some time to update other things
                Thread.sleep(10); // Sleep for a bit to make for a nicer paced animation
                simulation.update(); // Tell the simulation to update
            }

            screen.stopScreen();
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }
    public static void render(LifeSimulator simulation, Screen screen, TextGraphics graphics) {
        screen.clear();
        for (int col = 0; col < simulation.getSizeX(); col++) {
            for (int row = 0; row < simulation.getSizeY(); row++) {
                if (simulation.getCell(col, row)) {
                    graphics.setCharacter(col, row, 'X');
                }
            }
        }
        try {
            screen.refresh();
        } catch (Exception ex) {
            System.out.println("Something bad happened1: " + ex.getMessage());
        }

    }

    public static void sampleRender(Screen screen, TextGraphics graphics, int xPos) {
        screen.clear();

        // Not very interesting, but showing how to set characters
        graphics.setCharacter(xPos, 10, 'X');

        // This is what causes the console to render the new state, it is required
        try {
            screen.refresh();
        } catch (Exception ex) {
            System.out.println("Something bad happened1: " + ex.getMessage());
        }
    }
}