package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.PorteDao;
import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
import br.com.mvlvidal.calcprocweb.model.Porte;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "porBean")
public class PorteBean implements Serializable {

    private Porte por1;
    private PorteDao porDao;
    private List<Porte> portes;
    private boolean editar;
    private TabelaPortes tabelaPortes;

    @PostConstruct
    public void init() {

        por1 = new Porte();
        porDao = new PorteDao();
        portes = new ArrayList<>();
        portes = porDao.listar();
        tabelaPortes = new TabelaPortes();
        this.editar = false;

    }

    public String salvar() {
        
        por1.setTabelaPortes(tabelaPortes);
        Porte por2 = porDao.salvar(por1);

        if (por2 != null) {           
            por1 = por2;
            this.editar = false;
            filtrarTabelaPortes();
            return "cad-porte";
        } else {
            return "cad-porte";
        }

    }

    public String editar(Long id) {
        if (id != null || id != 0) {
            this.editar = true;
            por1 = porDao.find(id);
            tabelaPortes = por1.getTabelaPortes();
            return "cad-porte";
        } else {
            return "";
        }
    }

    public String excluir(Long id) {
        if (id != null || id != 0) {
            por1 = porDao.deletar(id);
            filtrarTabelaPortes();
            return "cad-porte";
        } else {
            return "";
        }
    }

    public String filtrarTabelaPortes() {

        TabelaPortes edi = tabelaPortes;
        if (edi.getId() == 0) {
            portes = porDao.listar();
            return "cad-porte";
        } else {
            portes = porDao.listar(tabelaPortes.getId());
            return "cad-porte";
        }
    }

    public Porte getPor1() {
        return por1;
    }

    public void setPor1(Porte por1) {
        this.por1 = por1;
    }

    public List<Porte> getPortes() {
        return portes;
    }

    public void setPortes(List<Porte> portes) {
        this.portes = portes;
    }

    public boolean isEditar() {
        return editar;
    }

    public TabelaPortes getTabelaPortes() {
        return tabelaPortes;
    }

    public void setTabelaPortes(TabelaPortes tabelaPortes) {
        this.tabelaPortes = tabelaPortes;
    }

}
