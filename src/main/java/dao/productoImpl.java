package dao;
import java.sql.PreparedStatement;
import modelo.producto;

import java.sql.SQLException;



public class productoImpl extends Conexion implements ICRUD<producto> {
    @Override
    public void registrar(producto pro) throws Exception{
    this.conectar();
        try {
            String sql = "insert into PRODUCTO (NOMPRO,TIPPRO,PREPRO,DESPRO,STOCKPRO,ESTPRO,IDPROV) values (?,?,?,?,?,'A',?) ";
            try (PreparedStatement ps = this.getCn().prepareStatement(sql)) {
                ps.setString(1, pro.getNompro());
                ps.setString(2, pro.getTippro());
                ps.setDouble(3, pro.getPrepro());
                ps.setString(4, pro.getDespro());
                ps.setInt(5, pro.getStockpro());
                ps.setInt(6, pro.getIdprov());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            
        } finally {
            cerrar();
        }
    }
    
    
}
