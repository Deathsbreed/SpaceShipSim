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
	JMenuItem exitMenuItem;

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

	// FIXME: There are no errors in compilation or while running, but the menu bar does not appear
	public void menuSetup() {
		menuBar = new JMenuBar();
		simulationMenu = new JMenu("Simulation");
		exitMenuItem = new JMenuItem("Exit");

		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				panel.stop();
				System.exit(0);
			}
		});
		simulationMenu.add(exitMenuItem);
		menuBar.add(simulationMenu);
		frame.setJMenuBar(menuBar);
	}
	// !!!FIXME-END!!!

	public static void main(String[] args) { new SpaceShipSim(); }
}