package org.example.fourthLab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The main entry point for the application. It initializes the Spring application context and starts the Text User Interface (TUI).
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        TUI tui = context.getBean(TUI.class);

        tui.start();

        context.close();
    }
}