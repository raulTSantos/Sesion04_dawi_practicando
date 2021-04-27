package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMantUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtNom;
	private JTextField txtUs;
	private JTextField txtFech;
	private JTextField txtCla;
	private JTextField txtTipo;
	private JTextField txtEstado;
	private JTextField txtAp;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantUsuario frame = new FrmMantUsuario();
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
	public FrmMantUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMantenimientoUsuario = new JLabel("Mantenimiento Usuario");
		lblMantenimientoUsuario.setBounds(39, 11, 135, 14);
		contentPane.add(lblMantenimientoUsuario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(39, 75, 59, 14);
		contentPane.add(lblNombre);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(39, 169, 59, 14);
		contentPane.add(lblFecha);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(39, 107, 59, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(39, 144, 59, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(39, 50, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(39, 200, 59, 14);
		contentPane.add(lblClave);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(39, 241, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(39, 272, 59, 14);
		contentPane.add(lblEstado);
		
		txtCod = new JTextField();
		txtCod.setBounds(136, 44, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(136, 69, 135, 20);
		contentPane.add(txtNom);
		
		txtUs = new JTextField();
		txtUs.setColumns(10);
		txtUs.setBounds(136, 132, 107, 20);
		contentPane.add(txtUs);
		
		txtFech = new JTextField();
		txtFech.setColumns(10);
		txtFech.setBounds(136, 163, 107, 20);
		contentPane.add(txtFech);
		
		txtCla = new JTextField();
		txtCla.setColumns(10);
		txtCla.setBounds(136, 194, 107, 20);
		contentPane.add(txtCla);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(136, 235, 107, 20);
		contentPane.add(txtTipo);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(136, 266, 107, 20);
		contentPane.add(txtEstado);
		
		txtAp = new JTextField();
		txtAp.setColumns(10);
		txtAp.setBounds(136, 101, 135, 20);
		contentPane.add(txtAp);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				registrar();
			}
		});
		btnRegistrar.setBounds(297, 46, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			actualizar();
			}
		});
		btnActualizar.setBounds(297, 80, 89, 23);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				eliminar();
			
			}
		});
		btnEliminar.setBounds(297, 116, 89, 23);
		contentPane.add(btnEliminar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			consultar();
			}
		});
		btnConsultar.setBounds(297, 165, 89, 23);
		contentPane.add(btnConsultar);
	}
	void registrar(){
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manejadorEM = fabrica.createEntityManager();
		
		Usuario u=new Usuario();
		u.setNombre(txtNom.getText());
		u.setApellido(txtAp.getText());
		u.setUsuario(txtUs.getText());
		u.setClave(txtCla.getText());
		u.setFnacim(txtFech.getText());
		u.setTipo(Integer.parseInt(txtTipo.getText()));
		u.setEstado(Integer.parseInt(txtEstado.getText()));
		
		manejadorEM.getTransaction().begin();
		manejadorEM.persist(u);
		manejadorEM.getTransaction().commit();
		
		manejadorEM.close();
		fabrica.close();
		JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");
		limpiuar();
	}
	
	void consultar(){
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manejadorEM = fabrica.createEntityManager();
		
		Usuario u = manejadorEM.find(Usuario.class, Integer.parseInt(txtCod.getText()));
		
		if (u !=null) {
			txtNom.setText(u.getNombre());		
			txtAp.setText(u.getApellido());
			txtUs.setText(u.getUsuario());
			txtCla.setText(u.getClave());
			txtFech.setText(u.getFnacim());
			txtTipo.setText(Integer.toString(u.getTipo()));
			txtEstado.setText(Integer.toString(u.getEstado()));
			
		} else {
			JOptionPane.showMessageDialog(this, "Usuario no existe");
			limpiuar();	
		}
		
		
		manejadorEM.close();
		fabrica.close();
	}
	void actualizar(){
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manejadorEM = fabrica.createEntityManager();
		Usuario u = manejadorEM.find(Usuario.class, Integer.parseInt(txtCod.getText()));
		
		if (u !=null) {
			
			u.setNombre(txtNom.getText());
			u.setApellido(txtAp.getText());
			u.setUsuario(txtUs.getText());
			u.setClave(txtCla.getText());
			u.setFnacim(txtFech.getText());
			u.setTipo(Integer.parseInt(txtTipo.getText()));
			u.setEstado(Integer.parseInt(txtEstado.getText()));
			
			
			manejadorEM.getTransaction().begin();
			manejadorEM.merge(u);
			manejadorEM.getTransaction().commit();
		} else {
			JOptionPane.showMessageDialog(this, "Usuario no existe");
			limpiuar();	
		}
				
		manejadorEM.close();
		fabrica.close();

	}
	void eliminar(){
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manejadorEM = fabrica.createEntityManager();
		Usuario u = manejadorEM.find(Usuario.class, Integer.parseInt(txtCod.getText()));
		if (u !=null) {
	
			manejadorEM.getTransaction().begin();
			manejadorEM.remove(u);
			manejadorEM.getTransaction().commit();
			JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente");
		} else {
			JOptionPane.showMessageDialog(this, "Usuario no existe");
			limpiuar();	
		}
		manejadorEM.close();
		fabrica.close();
	}
	
	
	void limpiuar(){
		txtCod.setText("");	
		txtNom.setText("");		
		txtAp.setText("");
		txtUs.setText("");
		txtCla.setText("");
		txtFech.setText("");
		txtTipo.setText("");
		txtEstado.setText("");
		
		txtCod.requestFocus();
	}
	
}
