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
	JMenuItem instructionsItem;
	JMenuItem licenseItem;
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
		instructionsItem = new JMenuItem("Instructions");
		licenseItem = new JMenuItem("License");
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

		instructionsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new Window("Instructions", "Accelerate: Up Arrow\n" +
					"Turn left: Left Arrow\n" +
					"Turn right: Right Arrow\n\n");
			}
		});
		licenseItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new Window("License Information",
					"SpaceShipSim " + panel.version + ", a simulation of a spaceship in a frictionless environment\n" +
					"Copyright (C) 2014 Nicolás A. Ortega\n\n" +
					"This program is free software: you can redistribute it and/or modify\n" +
					"it under the terms of the GNU General Public License as published by\n" +
					"the Free Software Foundation, either version 3 of the License, or\n" +
					"(at your option) any later version.\n\n" +
					"This program is distributed in the hope that it will be useful,\n" +
					"but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
					"MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n" +
					"GNU General Public License for more details.\n\n" +
					"You should have received a copy of the GNU General Public License\n" +
					"along with this program.  If not, see <http://www.gnu.org/licenses/>.\n\n");
			}
		});
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new Window("About", "SpaceShipSim +" + panel.version + "\n" +
					"Copyright (C) 2014 Nicolás A. Ortega\n" +
					"Contact: nicolas.ortega.froysa@gmail.com\n" +
					"Source-code: https://github.com/Deathsbreed/SpaceShipSim\n" +
					"Developers: Nicolás Ortega\n\n");
			}
		});

		resetItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));


		simulationMenu.add(resetItem);
		simulationMenu.addSeparator();
		simulationMenu.add(exitItem);

		helpMenu.add(instructionsItem);
		helpMenu.add(licenseItem);
		helpMenu.addSeparator();
		helpMenu.add(aboutItem);

		menuBar.add(simulationMenu);
		menuBar.add(helpMenu);

		frame.setJMenuBar(menuBar);
	}

	public static void main(String[] args) { new SpaceShipSim(); }
}