package geradorQRCodeBarCode;

import java.awt.Color;//
import java.awt.EventQueue;
import java.awt.event.ActionEvent;//
import java.awt.event.ActionListener;//

import javax.swing.ImageIcon;//
import javax.swing.JButton;//
import javax.swing.JFrame;
import javax.swing.JLabel;//
import javax.swing.JOptionPane;//
import javax.swing.JPanel;//
import javax.swing.JTextField;//
import javax.swing.border.EmptyBorder;//
import javax.swing.border.LineBorder;//

import metodos.MetodosQRCodeBarCode;



public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCampo;
	private JLabel lblImage;
	private JButton btnBarCode;
	private JButton btnQRCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtCampo = new JTextField();
		txtCampo.setBounds(26, 6, 385, 28);
		contentPane.add(txtCampo);
		txtCampo.setColumns(10);

		btnQRCode = new JButton("QR Code");

		btnQRCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				do_ButtonQRCode_actionPerformed(e);//b
				//do_buttonQRCode_actionPerformed(e);

			}

		});
		btnQRCode.setBounds(85, 45, 90, 28);
		contentPane.add(btnQRCode);

		btnBarCode = new JButton("Bar Code");
		btnBarCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				do_ButtonBarCode_actionPerformed(e);//b
				//do_buttonBarCode_actionPerformed(e);
			}
		});
		btnBarCode.setBounds(254, 45, 89, 26);
		contentPane.add(btnBarCode);

		lblImage = new JLabel("");
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImage.setBounds(47, 101, 338, 118);
		contentPane.add(lblImage);
	}

	protected void do_ButtonQRCode_actionPerformed(ActionEvent e) {

		String productId = txtCampo.getText();
		if (productId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor preencha o QRCode acima.");
		} else {
			byte[] result = MetodosQRCodeBarCode.getQRCodeImage(productId, 150, 150);
			lblImage.setIcon(new ImageIcon(result));
		}

	}

	protected void do_ButtonBarCode_actionPerformed(ActionEvent e) {
	
		String productId = txtCampo.getText();
		if (productId.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor preencha o BarCode acima.");
		} else {
			byte[] result = MetodosQRCodeBarCode.getBarCodeImage(productId, 200, 100);
			lblImage.setIcon(new ImageIcon(result));
		}

	}
}
