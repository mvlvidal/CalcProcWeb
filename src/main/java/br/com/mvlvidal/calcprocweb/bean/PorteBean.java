package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.PorteDao;
import br.com.mvlvidal.calcprocweb.model.Edicao;
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
    private Edicao edicao;

    @PostConstruct
    public void init() {

        por1 = new Porte();
        porDao = new PorteDao();
        portes = new ArrayList<>();
        portes = porDao.listar();
        edicao = new Edicao();
        this.editar = false;

    }

    public String salvar() {
        por1.setEdicao(edicao);
        Porte por2 = porDao.salvar(por1);

        if (por2 != null) {           
            por1 = por2;
            this.editar = false;
            filtrarEdicao();
            return "cad-porte";
        } else {
            return "cad-porte";
        }

    }

    public String editar(Long id) {
        if (id != null || id != 0) {
            this.editar = true;
            por1 = porDao.find(id);
            edicao = por1.getEdicao();
            return "cad-porte";
        } else {
            return "";
        }
    }

    public String excluir(Long id) {
        if (id != null || id != 0) {
            por1 = porDao.deletar(id);
            filtrarEdicao();
            return "cad-porte";
        } else {
            return "";
        }
    }

    public String filtrarEdicao() {

        Edicao edi = edicao;
        if (edi.getId() == 0) {
            portes = porDao.listar();
            return "cad-porte";
        } else {
            portes = porDao.listar(edicao.getId());
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

    public Edicao getEdicao() {
        return edicao;
    }

    public void setEdicao(Edicao edicao) {
        this.edicao = edicao;
    }

}
