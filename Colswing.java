package bd;

import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.Scrollbar;
import javax.swing.JTable;

public class Colswing {

	JFrame frmCigarrillosCrud;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblPaises;
	private JPanel panel_4;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnInactivar;
	private JButton btnNewButton_4;
	private JButton btnInactivar_1;
	private JButton btnInactivar_2;
	private JLabel lblCdigo;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblDescripcin_1;
	private JPanel panel_7;
	private JLabel lblEstadoRegistro;
	private JTable table;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Colswing window = new Colswing();
					window.frmCigarrillosCrud.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Colswing() throws SQLException {
		
		initialize();
	}

	private void initialize() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/cigarrillos";
		String username = "root";
		String password = "";
		
		frmCigarrillosCrud = new JFrame();
		frmCigarrillosCrud.setTitle("CIGARRILLOS - CRUD - JBDC");
		frmCigarrillosCrud.getContentPane().setBackground(SystemColor.activeCaption);
		frmCigarrillosCrud.getContentPane().setForeground(Color.WHITE);
		frmCigarrillosCrud.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Registro de Colores"));
		panel.setBounds(10, 56, 541, 99);
		frmCigarrillosCrud.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(10, 21, 169, 14);
		panel.add(lblNewLabel);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(10, 46, 169, 14);
		panel.add(lblDescripcin);
		
		JLabel lblEstadoDeRegistro = new JLabel("Estado de registro");
		lblEstadoDeRegistro.setBounds(10, 71, 164, 14);
		panel.add(lblEstadoDeRegistro);
		
		textField = new JTextField();
		textField.setBounds(189, 18, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 43, 314, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(189, 68, 28, 20);
		panel.add(textField_2);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Tabla_Paises"));
		panel_1.setBounds(10, 166, 541, 209);
		frmCigarrillosCrud.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 21, 2, 2);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 21, 521, 177);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 521, 22);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBounds(0, 0, 177, 22);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 0, 157, 22);
		panel_5.add(lblCdigo);
		lblCdigo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCdigo.setBackground(SystemColor.activeCaption);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setLayout(null);
		panel_6.setBounds(177, 0, 169, 22);
		panel_3.add(panel_6);
		
		lblDescripcin_1 = new JLabel("Descripci\u00F3n");
		lblDescripcin_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblDescripcin_1.setBackground(SystemColor.activeCaption);
		lblDescripcin_1.setBounds(10, 0, 130, 22);
		panel_6.add(lblDescripcin_1);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_7.setLayout(null);
		panel_7.setBounds(344, 0, 177, 22);
		panel_3.add(panel_7);
		
		lblEstadoRegistro = new JLabel("Estado Registro");
		lblEstadoRegistro.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEstadoRegistro.setBackground(SystemColor.activeCaption);
		lblEstadoRegistro.setBounds(10, 0, 142, 22);
		panel_7.add(lblEstadoRegistro);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setBackground(Color.WHITE);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setBounds(10, 33, 501, 108);
		panel_2.add(table);
		try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM gzl_color;");	
			while(myRs.next()) {
				String CodCol=myRs.getString("CodCol");
				String DesColCig=myRs.getString("DesColCig");
				String EstCol=myRs.getString("EstCol");
								
				String []tbData= {CodCol,DesColCig,EstCol};						
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				tblModel.addRow(tbData);					
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = table.columnAtPoint(evt.getPoint());
		        if (row >= 0 && col >= 0) {
		        	String TablaCod = table.getModel().getValueAt(row, 0).toString();
		        	String TablaDes = table.getModel().getValueAt(row, 1).toString();
		        	String TablaEstReg = table.getModel().getValueAt(row, 2).toString();
		        	textField.setText(TablaCod);
		        	textField_1.setText(TablaDes);
		        	textField_2.setText(TablaEstReg);
		        }
		    }
		});
		
		lblPaises = new JLabel("COLOR");
		lblPaises.setBackground(SystemColor.activeCaption);
		lblPaises.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPaises.setBounds(10, 11, 169, 34);
		frmCigarrillosCrud.getContentPane().add(lblPaises);
		
		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(10, 386, 541, 78);
		frmCigarrillosCrud.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CodCol = textField.getText();
				String DesColCig = textField_1.getText();
				String EstCol = textField_2.getText();				
				if (!isInteger(CodCol)||CodCol.equals("")||DesColCig.equals("")||EstCol.equals("")||(!EstCol.equals("I")&&!EstCol.equals("A"))) {
					JOptionPane.showMessageDialog(panel, "Datos err�neos");
				}else {
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("INSERT INTO `gzl_color` (`CodCol`, `DesColCig`, `EstCol`)  VALUES ('"+CodCol+"','"+DesColCig+"','"+EstCol+"');");					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Registro A�adido!");
				}
			}			
		});
		btnNewButton.setBounds(164, 11, 89, 23);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;				
				int row = table.getSelectedRow();
				String Colcodigo = table.getModel().getValueAt(row, column).toString();
				
				String CodCol = textField.getText();
				String DesColCig = textField_1.getText();
				String EstCol = textField_2.getText();
										
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("UPDATE gzl_color SET CodCol ='"+CodCol+"',DesColCig ='"+DesColCig+"',EstCol ='"+EstCol+"' WHERE CodCol = "+Colcodigo+";");					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Registro Modificado!");
			}
		});
		btnNewButton_1.setBounds(44, 11, 89, 23);
		panel_4.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(panel, "�Deseas eliminar este registro?");
				switch (result) {
		         case JOptionPane.YES_OPTION:
		        	int column = 0;
					int row = table.getSelectedRow();
					String CodCol = table.getModel().getValueAt(row, column).toString();
					
		        	 try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
							Statement myStmt = myConn.createStatement();
							myStmt.executeUpdate("DELETE FROM gzl_color WHERE CodCol = '"+CodCol+"';");					
						} catch (SQLException e1) {
							e1.printStackTrace();
						}		        	 
		        	 JOptionPane.showMessageDialog(panel, "Registro eliminado");
		         break;
		         case JOptionPane.NO_OPTION:
		        	 JOptionPane.showMessageDialog(panel, "Registro no eliminado");
		         break;		         
		      }
			}
		});
		btnNewButton_2.setBounds(284, 11, 89, 23);
		panel_4.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(404, 45, 89, 23);
		panel_4.add(btnNewButton_3);
		
		btnInactivar = new JButton("Inactivar");
		btnInactivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				String CodCol = table.getModel().getValueAt(row, column).toString();
				
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("UPDATE gzl_color SET EstCol ='I' WHERE CodCol = "+CodCol+";");					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Registro Inactivado!");
			}
		});
		btnInactivar.setBounds(44, 45, 89, 23);
		panel_4.add(btnInactivar);
		
		btnNewButton_4 = new JButton("Cancelar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				   
			}
		});
		btnNewButton_4.setBounds(404, 11, 89, 23);
		panel_4.add(btnNewButton_4);
		
		btnInactivar_1 = new JButton("Reactivar");
		btnInactivar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 0;
				int row = table.getSelectedRow();
				String CodCol = table.getModel().getValueAt(row, column).toString();
				
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate("UPDATE gzl_color SET EstCol ='A' WHERE CodCol = "+CodCol+";");					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(panel, "Registro Activado!");
			}
		});
		btnInactivar_1.setBounds(164, 45, 89, 23);
		panel_4.add(btnInactivar_1);
		
		btnInactivar_2 = new JButton("Actualizar");
		btnInactivar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try (Connection myConn = DriverManager.getConnection(dbURL, username, password)){					
					Statement myStmt = myConn.createStatement();
					ResultSet myRs = myStmt.executeQuery("SELECT * FROM gzl_color;");
					DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
					tblModel.setRowCount(0);
					while(myRs.next()) {
						String CodCol=myRs.getString("CodCol");
						String DesColCig=myRs.getString("DesColCig");
						String EstCol=myRs.getString("EstCol");
						
						System.out.println(myRs.getString("CodCol") + 
								", " + myRs.getString("DesColCig")+ 
								", "+myRs.getString("EstCol") );						
						String []tbData= {CodCol,DesColCig,EstCol};	
						tblModel.addRow(tbData);					
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}						
			}						
		});		
		btnInactivar_2.setBounds(284, 45, 89, 23);
		panel_4.add(btnInactivar_2);
		frmCigarrillosCrud.setBounds(100, 100, 577, 514);
		frmCigarrillosCrud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
}
