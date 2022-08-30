package pe.idat.ec4.sohail.arata.dao;

import java.sql.*;
import java.util.*;
import pe.idat.ec4.sohail.arata.dbase.Conexion;
import pe.idat.ec4.sohail.arata.vo.Planeta;
import pe.idat.ec4.sohail.arata.vo.Satelite;

public class SateliteDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private PlanetaDao planetaDao = new PlanetaDao();

    public SateliteDao() {
    }

    public void insert(Satelite satelite) {
        try {
            conn = Conexion.MyConnect();
            ps = conn.prepareCall("insert into satelites(nombre, altura, masa, id_planetas) values(?,?,?,?)");

            ps.setString(1, satelite.getNombre());
            ps.setDouble(2, satelite.getAltura());
            ps.setDouble(3, satelite.getMasa());
            ps.setInt(4, satelite.getPlaneta().getId_planeta());

            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new Exception("Error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Satelite findById(int id_satelites) {
        Satelite satelite = null;

        try {
            conn = Conexion.MyConnect();
            ps = conn.prepareCall("select * from Satelites where id_satelites=?");
            ps.setInt(1, id_satelites);
            rs = ps.executeQuery();

            if (rs.next()) {
                satelite = new Satelite();
                satelite.setId_satelite(rs.getInt("id_satelites"));
                satelite.setNombre(rs.getString("nombre"));
                satelite.setAltura(rs.getDouble("altura"));
                satelite.setMasa(rs.getDouble("masa"));

                Planeta planeta = planetaDao.findById(rs.getInt("id_planetas"));
                satelite.setId_satelite(id_satelites);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return satelite;
    }

    public Collection<Satelite> findAll() {
        List<Satelite> list = new ArrayList<>();

        try {
            conn = Conexion.MyConnect();
            ps = conn.prepareCall("select * from satelites");
            rs = ps.executeQuery();

            while (rs.next()) {
                Satelite satelite = new Satelite();

                satelite.setId_satelite(rs.getInt("id_satelites"));
                satelite.setNombre(rs.getString("nombre"));
                satelite.setAltura(rs.getDouble("altura"));
                satelite.setMasa(rs.getDouble("masa"));

                Planeta planeta = planetaDao.findById(rs.getInt("id_planetas"));
                satelite.setPlaneta(planeta);

                list.add(satelite);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
