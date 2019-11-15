package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;

public class Pedido {
	private int id;
	private Date data;
	private int totalItens;
	private Double totalPedido;
	private boolean cancelado;

	@Override
	public String toString() {
		return "Pedido [data=" + data + ", totalItens=" + totalItens + ", totalPedido=" + totalPedido
				+ ", cancelado=" + cancelado + "]";
	}

	public Pedido(Date data, int totalItens, Double totalPedido, boolean cancelado) {
		super();
		this.data = data;
		this.totalItens = totalItens;
		this.totalPedido = totalPedido;
		this.cancelado = cancelado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(int totalItens) {
		this.totalItens = totalItens;
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(Double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public void inserir(Connection conn) {

		String comando = "insert into pedido (data, totalItens, totalPedido, cancelado) values(?,?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)) {

			ps.setDate(1, (java.sql.Date) getData());
			ps.setInt(2, getTotalItens());
			ps.setDouble(3, getTotalPedido());
			ps.setBoolean(4, isCancelado());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void carregar(Connection conn) {
		String comando = "select data, totalItens, totalPedido, cancelado from pedido where idPedido=?";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {

			int var = Integer.parseInt(JOptionPane.showInputDialog("Digite o id"));
			pst.setInt(1, var);

			try (ResultSet rs = pst.executeQuery();) {
				if (rs.next()) {
					data = rs.getDate("data");
					totalItens = rs.getInt("totalItens");
					totalPedido = rs.getDouble("totalPedido");
					cancelado = rs.getBoolean("cancelado");
				} else {
					id = -1;
					//codigo = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void exclusaoLogica(Connection conn) {
		String comando = "update pedido set cancelado = ? where idPedido=?";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {

			pst.setBoolean(1, false);
			int var = Integer.parseInt(JOptionPane.showInputDialog("Digite o id pedido"));
			pst.setInt(2, var);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Connection conn) {
		String comando = "update pedido set totalItens=?, totalPedido=? where idPedido=?";
		try (PreparedStatement pst = conn.prepareStatement(comando);) {
			
			int var0 = Integer.parseInt(JOptionPane.showInputDialog("Digite o id pedido"));
			int var1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o total Itens"));
			Double var2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o total Pedido"));

			pst.setInt(1, var1);
			pst.setDouble(2, var2);
			pst.setDouble(3, var0);

			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
