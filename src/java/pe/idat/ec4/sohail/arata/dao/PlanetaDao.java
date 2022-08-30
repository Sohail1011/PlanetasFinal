package pe.idat.ec4.sohail.arata.dao;

import java.sql.*;
import java.util.*;
import pe.idat.ec4.sohail.arata.dbase.Conexion;
import pe.idat.ec4.sohail.arata.vo.Planeta;

public class PlanetaDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public PlanetaDao() {
    }

    public Planeta findById(int id_planeta) {
        Planeta planeta = null;

        try {
            conn = Conexion.MyConnect();
            ps = conn.prepareCall("select * from planetas where id_planetas=?");
            ps.setInt(1, id_planeta);
            rs = ps.executeQuery();

            if (rs.next()) {
                planeta = new Planeta();
                planeta.setId_planeta(rs.getInt("id_planetas"));
                planeta.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeta;
    }

    public Collection<Planeta> findAll() {
        List<Planeta> list = new ArrayList<>();

        try {
            conn = Conexion.MyConnect();
            ps = conn.prepareCall("select * from planetas");
            rs = ps.executeQuery();

            while (rs.next()) {
                Planeta planeta = new Planeta();

                planeta.setId_planeta(rs.getInt("id_planetas"));
                planeta.setNombre(rs.getString("nombre"));

                list.add(planeta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Planeta planeta) {
        try {
            conn = Conexion.MyConnect();
            ps = conn.prepareCall("insert into planetas(nombre) values(?)");

            ps.setString(1, planeta.getNombre());

            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new Exception("Error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
