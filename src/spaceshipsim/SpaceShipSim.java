package spaceshipsim;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author Nicolás A. Ortega
 * @copyright Nicolás A. Ortega
 * @license GNU GPLv3
 * @year 2014
 * 
 */
public class SpaceShipSim {
	private JFrame frame;
	private SimPanel panel;

	// Menu items
	JMenuBar menuBar;

	JMenu simulationMenu;
	JMenuItem resetItem;
	JMenuItem exitItem;

	JMenu helpMenu;
	JMenuItem aboutItem;

	// Constructor:
	public SpaceShipSim() {
		frame = new JFrame("SpaceShipSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new SimPanel();
		frame.add(panel);
		menuSetup();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

	public void menuSetup() {
		menuBar = new JMenuBar();
		simulationMenu = new JMenu("Simulation");
		resetItem = new JMenuItem("Reset");
		exitItem = new JMenuItem("Exit");
		helpMenu = new JMenu("Help");
		aboutItem = new JMenuItem("About");

		resetItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) { panel.reset(); }
		});
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panel.stop();
				System.exit(0);
			}
		});

		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				// Stuff happens.
			}
		});


		simulationMenu.add(resetItem);
		simulationMenu.addSeparator();
		simulationMenu.add(exitItem);

		helpMenu.add(aboutItem);

		menuBar.add(simulationMenu);
		menuBar.add(helpMenu);

		frame.setJMenuBar(menuBar);
	}

	public static void main(String[] args) { new SpaceShipSim(); }
}