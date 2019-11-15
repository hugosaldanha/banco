package projeto;

import java.sql.Connection;
import java.util.List;

public class Teste {
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);

			// MERCARDORIA
			Mercadoria merc = new Mercadoria();
//			merc.inserir(conn);
//			merc.atualizar(conn);
//			merc.exclusaoLogica(conn);
			//merc.carregar(conn);
//			System.out.println(merc.toString());
//			List <Mercadoria> lista = merc.semCodigo(conn);
//			
//			for(Mercadoria m : lista) {
//				System.out.println(m.toString());
//			}
			
			
//			// PEDIDO
			//Pedido ped = new Pedido(Date.valueOf("2019-11-01"), 5, 5.0, true);
//			ped.inserir(conn);
//			ped.atualizar(conn);
//			ped.carregar(conn);
//			ped.exclusaoLogica(conn);
//			System.out.println(ped.toString());
//			
//			
//			//VENDA
			Venda venda = new Venda();
			//venda.inserir(conn);
//			venda.atualizar(conn);
//			venda.carregar(conn);
//			venda.exclusaoLogica(conn);
			//System.out.println(venda.toString());
			venda.deleteVenda(conn, 7, "9638527414512");
			
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
