package projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Venda {

	private Mercadoria mercadoria;
	private int id;
	private Pedido pedido;
	private int quantidade;
	private double preco;

	@Override
	public String toString() {
		return "Venda [mercadoria=" + mercadoria + ", pedido=" + pedido + ", quantidade=" + quantidade + ", preco="
				+ preco + "]";
	}

	public Venda() {
		super();
	}

	public Venda(Mercadoria mercadoria, Pedido pedido, int quantidade, Double preco) {
		super();
		this.mercadoria = mercadoria;
		this.pedido = pedido;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Mercadoria getMercadoria() {
		return mercadoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMercadoria(Mercadoria mercadoria) {
		this.mercadoria = mercadoria;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void inserir(Connection conn) {

		String comando = "insert into venda (quantidade, preco, mercadoria_idMercadoria, pedido_idpedido) values(?,?,?,?)";
		try (PreparedStatement ps = conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)) {

			ps.setInt(1, getQuantidade());
			ps.setDouble(2, getPreco());
			ps.setInt(3, getMercadoria().getId());
			ps.setInt(4, getPedido().getId());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteVenda(Connection conn, int idPedido, String codigoMercadoria) {
		String comando = "SELECT V.IDVENDA FROM VENDA AS V INNER JOIN MERCADORIA AS M ON V.mercadoria_idMercadoria = M.IDMERCADORIA INNER JOIN PEDIDO AS P ON P.IDPEDIDO = V.PEDIDO_IDPEDIDO WHERE P.IDPEDIDO = ? AND M.CODIGO = ?";
		List<Integer> deletaveis = new ArrayList();
		try (PreparedStatement pst = conn.prepareStatement(comando);) {
			pst.setInt(1, idPedido);
			pst.setString(2, codigoMercadoria);
			try (ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					deletaveis.add(rs.getInt(1));
				}
			}
			for (Integer id : deletaveis) {
				delete(conn, id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(Connection conn, int id) {
		String comando = "delete from venda where idvenda = ?";
		try (PreparedStatement ps = conn.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS)) {

			ps.setInt(1, id);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
