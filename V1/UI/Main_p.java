package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Cliente;
import Logica.Login;
import Logica.Pieza;
import Logica.Vehiculo;
import Logica.Vendedor;
import negocio.Verificar;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Main_p extends JFrame {

	private JPanel panelprincipal;
	private int autenticador;
	Login empleado = new Login(0, 0, null, null, null, null);
	Login cliente = new Login(0, 0, null, null);
	JPanel panel_menu = new JPanel();
	JPanel panel_opcion = new JPanel();
	registrar_auto registrar_auto = new registrar_auto();
	buscar_cliente buscar_cliente = new buscar_cliente();
	buscar_cliente buscar_cliente_1 = new buscar_cliente();
	buscar_cliente buscar_cliente_2 = new buscar_cliente();
	buscar_cliente buscar_cliente_3 = new buscar_cliente();
	buscar_cliente buscar_cliente_4 = new buscar_cliente();
	comprar_auto comprar_auto = new comprar_auto();
	RR_auto rrAuto = new RR_auto();
	Vender_pieza vender_pieza = new Vender_pieza();
	Vender_auto vender_auto = new Vender_auto();
	loginaux p = new loginaux();
	registro r = new registro();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Windows".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (Exception e) {
					// handle exception
				}
				try {
					Main_p frame = new Main_p();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_p() {
		setTitle("Automerges");
		menu();
	}

	public void menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		panelprincipal = new JPanel();
		panelprincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelprincipal);
		panelprincipal.setLayout(null);

		JButton btnNewButton = new JButton("Registrarse");
		JButton btnNewButton_1 = new JButton("Loguearse");
		JLabel lblNewLabel = new JLabel("seleccione una opcion");

		panel_menu.setBounds(0, 0, 210, 563);
		panel_menu.setBackground(Color.WHITE);
		panelprincipal.add(panel_menu);
		panel_opcion.setBounds(209, 0, 577, 563);
		panel_opcion.setBackground(Color.WHITE);
		panelprincipal.add(panel_opcion);
		panel_opcion.revalidate();
		panel_opcion.repaint();

		p.setBorder(null);
		panel_menu.removeAll();
		panel_menu.setLayout(null);

		if (!p.isLogueado()) {

			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel_opcion.removeAll();
					r.setBorder(null);
					panel_opcion.add(r);
					panel_opcion.revalidate();
					panel_opcion.repaint();
				}
			});

			btnNewButton.setBounds(50, 180, 128, 55);
			panel_menu.add(btnNewButton);

			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					panel_opcion.removeAll();

					JButton loguear = new JButton("Ingresar");
					loguear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							p.parametros();
							p.pintar();
							System.err.println(p.getI());
							System.err.println(p.getContrasena());
							System.err.println(p.getUsuario());
							Verificar verificar = new Verificar();

							if (p.getI() == 1) {
								if (verificar.verificarcontrasena(p.getContrasena())
										&& verificar.verificardni(p.getUsuario())) {

									if (cliente.TraerUsuarios(p.getContrasena(), p.getUsuario())) {

										if (!cliente.getApellido().equals(null)) {
											p.setLogueado(true);
											panelprincipal.revalidate();
											panelprincipal.repaint();
											p.delete();
											System.err.println("no exeiste el menu pero esta loqueado");
										}
									}
								}
							} else {
								if (verificar.verificarcontrasena(p.getContrasena())
										&& verificar.verificardni(p.getUsuario())) {
									if (empleado.TraerEmleados(p.getContrasena(), p.getUsuario())) {

										if (!empleado.getApellido().equals(null)) {
											System.err.println(empleado.getApellido());
											p.setLogueado(true);
											panelprincipal.revalidate();
											panelprincipal.repaint();
											p.delete();
											Timer myTimer = new Timer(10000, menuactivador());
											
										}
									}
								}

							}
						}

						private ActionListener menuactivador() {
							menu2();
							return null;
						}

					});
					loguear.setBounds(217, 436, 106, 43);
					p.add(loguear);

					p.setBorder(null);
					panel_opcion.add(p);
					panel_opcion.revalidate();
					panel_opcion.repaint();

				}

			});

			btnNewButton_1.setBounds(50, 340, 128, 55);
			panel_menu.add(btnNewButton_1);
			panel_menu.revalidate();
			panel_menu.repaint();
			panel_opcion.setLayout(new BorderLayout(0, 0));

			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			panel_opcion.add(lblNewLabel, BorderLayout.CENTER);

		} else {

		}
		autenticador = p.getI();

		panel_menu.addPropertyChangeListener(new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent evt) {
				if (p.isLogueado()) {

				} else {

				}
			}

		});

		revalidate();
		repaint();
	}

	public void menu2() {
		panel_menu.removeAll();

		Vehiculo vehiculo = new Vehiculo(0, "", "", "", 0, 0, 0, "");
		Cliente cliente = new Cliente("", "", "", "", "");
		Pieza pieza = new Pieza(0, 0, null);
		Vendedor vendedor = new Vendedor(empleado.getNombre(), empleado.getApellido(),
				String.valueOf(empleado.getDni()), String.valueOf(empleado.getId()), empleado.getClave(),
				empleado.getTipo(), vehiculo, pieza, cliente);

		JButton vender_auto_acc = new JButton("Vender auto");
		vender_auto_acc.setBounds(35, 94, 120, 38);
		panel_menu.add(vender_auto_acc);

		JButton vender_pieza_acc = new JButton("Vender pieza");
		vender_pieza_acc.setBounds(35, 160, 120, 38);
		panel_menu.add(vender_pieza_acc);

		JButton reparar_auto_acc = new JButton("Reparar auto");
		reparar_auto_acc.setBounds(35, 226, 120, 38);
		panel_menu.add(reparar_auto_acc);

		JButton ver_Stock = new JButton("Ver estacionamiento");
		ver_Stock.setBounds(35, 292, 120, 38);
		panel_menu.add(ver_Stock);

		JButton registrar_auto_acc = new JButton("Registrar auto");
		registrar_auto_acc.setBounds(35, 358, 120, 38);
		panel_menu.add(registrar_auto_acc);

		JButton buscar_auto_acc = new JButton("Buscar auto");
		buscar_auto_acc.setBounds(35, 424, 120, 38);

		panel_menu.add(buscar_auto_acc);

		JButton logout = new JButton("Logout");
		logout.setBounds(35, 490, 120, 38);
		panel_menu.add(logout);

		JButton comprar_auto_acc = new JButton("Comprar auto");
		comprar_auto_acc.setBounds(35, 28, 120, 38);
		panel_menu.add(comprar_auto_acc);

		panel_menu.revalidate();
		panel_menu.repaint();

		String mensaje = "Bienvenido " + empleado.getNombre() + " " + empleado.getApellido()
				+ "\n Seleccione una opcion";
		JLabel saludo = new JLabel(mensaje);
		panel_opcion.removeAll();
		saludo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		saludo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_opcion.add(saludo, BorderLayout.CENTER);
		panel_opcion.revalidate();
		panel_opcion.repaint();

		Buscar_auto buscar = new Buscar_auto();
		buscar.setVendedor(vendedor);
		buscar_auto_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_opcion.removeAll();
				panel_opcion.add(buscar);
				panel_opcion.revalidate();
				panel_opcion.repaint();
			}
		});
		
		
		
		vender_auto_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vender_auto.table_generator();
				panel_opcion.removeAll();
				panel_opcion.add(vender_auto);
				panel_opcion.revalidate();
				panel_opcion.repaint();
			}
		});
		
		//main panel 
		JButton btnNewButton_vender = new JButton("seleccionar cliente");
		btnNewButton_vender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venderauto(1);
				//System.err.println("click");
			}
		});
		btnNewButton_vender.setBounds(188, 96, 192, 37);
		vender_auto.add(btnNewButton_vender);
		vender_auto.setVendedor(vendedor);

		JButton seleccion_1 = new JButton("seleccionar");
		seleccion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vender_auto.setClient(buscar_cliente_1.seleccionarcliente());
				vender_auto.setNombre_apellido(buscar_cliente_1.seleccionarcliente_nombre());
				vender_auto.setNombrec(buscar_cliente_1.seleccionarnombre());
				vender_auto.setApellidoc(buscar_cliente_1.seleccionarapellido());
				vender_auto.setDni(buscar_cliente_1.seleccionardni());
				vender_auto.title();
				//System.out.println(rrAuto.getClient());
				venderauto(0);
			}
		});
		
		JButton atras_1 = new JButton("atras");
		atras_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venderauto(0);
			}
		});

		atras_1.setBounds(125, 502, 96, 29);
		buscar_cliente_1.add(atras_1);
		buscar_cliente_1.setVendedor(vendedor);
		buscar_cliente_1.obtener_seleccion();
		seleccion_1.setBounds(346, 502, 96, 29);
		buscar_cliente_1.add(seleccion_1);
		buscar_cliente_1.revalidate();
		
		
		vender_pieza_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_opcion.removeAll();
				vender_pieza.setVendedor(vendedor);
				vender_pieza.generar_tabla();
				panel_opcion.add(vender_pieza);
				panel_opcion.revalidate();
				panel_opcion.repaint();
			}
		});
		
		//main panel 
		JButton btnNewButton_pieza = new JButton("seleccionar cliente");
		btnNewButton_pieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venderpieza(1);
				//System.err.println("click");
			}
		});
		btnNewButton_pieza.setBounds(188, 96, 192, 37);
		vender_pieza.add(btnNewButton_pieza);
		

		JButton seleccion_5 = new JButton("seleccionar");
		seleccion_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vender_pieza.setClient(buscar_cliente_4.seleccionarcliente());
				//System.out.println(rrAuto.getClient());
				venderpieza(0);
			}
		});
		
		JButton atras_5 = new JButton("atras");
		atras_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venderpieza(0);
			}
		});

		atras_5.setBounds(125, 502, 96, 29);
		buscar_cliente_4.add(atras_5);
		buscar_cliente_4.setVendedor(vendedor);
		buscar_cliente_4.obtener_seleccion();
		seleccion_5.setBounds(346, 502, 96, 29);
		buscar_cliente_4.add(seleccion_5);
		buscar_cliente_4.revalidate();

		
		
		
		
		
		
		rrAuto.setVendedor(vendedor);
		reparar_auto_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_opcion.removeAll();
				panel_opcion.add(rrAuto);
				panel_opcion.revalidate();
				panel_opcion.repaint();
			}
		});
		
		//main panel 
				JButton btnNewButton = new JButton("seleccionar cliente");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RR_vauto(1);
						//System.err.println("click");
					}
				});
				btnNewButton.setBounds(188, 96, 192, 37);
				rrAuto.add(btnNewButton);
				

				JButton seleccion_3 = new JButton("seleccionar");
				seleccion_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rrAuto.setClient(buscar_cliente_3.seleccionarcliente());
						//System.out.println(rrAuto.getClient());
						RR_vauto(0);
					}
				});
				
				JButton atras_3 = new JButton("atras");
				atras_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RR_vauto(0);
					}
				});

				atras_3.setBounds(125, 502, 96, 29);
				buscar_cliente_3.add(atras_3);
				buscar_cliente_3.setVendedor(vendedor);
				buscar_cliente_3.obtener_seleccion();
				seleccion_3.setBounds(346, 502, 96, 29);
				buscar_cliente_3.add(seleccion_3);
				buscar_cliente_3.revalidate();
		

		registrar_auto_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_opcion.removeAll();
				JButton btnNewButton_1 = new JButton("Agregar Cliente");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registrarautol(1);
					}
				});
				btnNewButton_1.setBounds(140, 318, 213, 47);

				JButton seleccion = new JButton("seleccionar");
				seleccion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registrar_auto.setCliente(buscar_cliente.seleccionarcliente());

						registrarautol(0);
					}
				});
				seleccion.setBounds(346, 502, 96, 29);
				buscar_cliente.add(seleccion);

				JButton atras = new JButton("atras");
				atras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registrarautol(0);
					}
				});

				atras.setBounds(125, 502, 96, 29);
				buscar_cliente.add(atras);
				buscar_cliente.setVendedor(vendedor);
				buscar_cliente.obtener_seleccion();
				registrar_auto.add(btnNewButton_1);
				registrar_auto.setVendedor(vendedor);
				panel_opcion.add(registrar_auto);
				panel_opcion.revalidate();
				panel_opcion.repaint();
			}
		});

		verstock stock = new verstock();
		stock.setVendedor(vendedor);
		ver_Stock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stock.precarga();
				panel_opcion.removeAll();
				panel_opcion.add(stock);
				panel_opcion.revalidate();
				panel_opcion.repaint();
			}
		});

		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_opcion.removeAll();
				p.setLogueado(false);
				panel_opcion.revalidate();
				panel_opcion.repaint();
				menu();
			}
		});
		
		
		comprar_auto.setVendedor(vendedor);
		comprar_auto_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_opcion.removeAll();
				panel_opcion.add(comprar_auto);
				panel_opcion.revalidate();
				panel_opcion.repaint();
				
				
//
				JButton btnNewButton_4 = new JButton("seleccionar cliente");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comprarauto(1);
						//System.err.println("click");
					}
				});
				btnNewButton_4.setBounds(188, 96, 192, 37);
				comprar_auto.add(btnNewButton_4);
				

				JButton seleccion_2 = new JButton("seleccionar");
				seleccion_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comprar_auto.setClient(buscar_cliente_2.seleccionarcliente());
						comprar_auto.table_generator();
						//System.out.println(rrAuto.getClient());
						comprarauto(0);
					}
				});
				
				JButton atras_2 = new JButton("atras");
				atras_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comprarauto(0);
					}
				});

				atras_2.setBounds(125, 502, 96, 29);
				buscar_cliente_2.add(atras_2);
				buscar_cliente_2.setVendedor(vendedor);
				buscar_cliente_2.obtener_seleccion();
				seleccion_2.setBounds(346, 502, 96, 29);
				buscar_cliente_2.add(seleccion_2);
				buscar_cliente_2.revalidate();
				
				//sumbit
		/*JButton btnNewButton = new JButton("realizar compra");
		btnNewButton.setBounds(196, 437, 150, 36);
		comprar_auto_acc.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venderauto(0);
			}
		});
		*/
		
		
		JButton btnNewButton_1 = new JButton("seleccionar cliente");
		btnNewButton_1.setBounds(196, 340, 150, 36);
		//comprar_auto_acc.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venderauto(1);
			}
		});
		
		
		
		JButton btnNewButton_2 = new JButton("seleccione un auto");
		btnNewButton_2.setBounds(196, 249, 150, 36);
		//comprar_auto_acc.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				venderauto(2);
			}
		});
			
				panel_opcion.revalidate();
				panel_opcion.repaint();

			}
		});

	}

	public void registrarautol(int The_Ultimate_Runner) {

		switch (The_Ultimate_Runner) {
		case 0:
			panel_opcion.removeAll();
			panel_opcion.add(registrar_auto);
			break;

		case 1:
			panel_opcion.removeAll();
			panel_opcion.add(buscar_cliente);
			break;
		}
		panel_opcion.revalidate();
		panel_opcion.repaint();

	}

	public void venderauto(int hyper) {

		switch (hyper) {
		case 0:
			panel_opcion.removeAll();
			panel_opcion.add(vender_auto);
			break;

		case 1:
			panel_opcion.removeAll();
			panel_opcion.add(buscar_cliente_1);
			break;
		
		}
		panel_opcion.revalidate();
		panel_opcion.repaint();
	}
	
	
	public void comprarauto(int mega) {

		switch (mega) {
		case 0:
			panel_opcion.removeAll();
			panel_opcion.add(comprar_auto);
			break;

		case 1:
			panel_opcion.removeAll();
			panel_opcion.add(buscar_cliente_2);
			break;
		
		}
		panel_opcion.revalidate();
		panel_opcion.repaint();
	}
	
	public void RR_vauto(int extra) {

		switch (extra) {
		case 0:
			panel_opcion.removeAll();
			panel_opcion.add(rrAuto);
			break;
 
		case 1:
			panel_opcion.removeAll();
			panel_opcion.add(buscar_cliente_3);
			break;
			
		case 2:
			panel_opcion.removeAll();
			panel_opcion.add(rrAuto);
			
			break;
		
		}
		panel_opcion.revalidate();
		panel_opcion.repaint();
	}

	public void venderpieza(int ultra) {

		switch (ultra) {
		case 0:
			panel_opcion.removeAll();
			panel_opcion.add(vender_pieza);
			break;

		case 1:
			panel_opcion.removeAll();
			panel_opcion.add(buscar_cliente_4);
			break;
		
		}
		panel_opcion.revalidate();
		panel_opcion.repaint();
	}
	
}
