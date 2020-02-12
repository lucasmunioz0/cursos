package beans.helper;

import beans.model.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named
@RequestScoped
public class ColoniaHelper {

    public List<Colonia> getColonias() {
        final List<Colonia> colonias = new ArrayList<>();

        int coloniaId = 1;
        Colonia colonia = new Colonia(coloniaId++, "Córdoba", 5000);
        colonias.add(colonia);
        colonia = new Colonia(coloniaId++, "Villa Allende", 5105);
        colonias.add(colonia);
        colonia = new Colonia(coloniaId++, "Mendiolaza", 5100);
        colonias.add(colonia);
        return colonias;
    }

    public int getColoniaIdPorNombre(String nombreColonia) {
        int coloniaId = 0;
        final List<Colonia> colonias = this.getColonias();
        for (Colonia colonia : colonias) {
            if (colonia.getNombre().equals(nombreColonia)) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }

        return coloniaId;
    }
    
    public int getColoniaNombrePorCodigoPostal(int codigoPostal){
        int coloniaId = 0;
        final List<Colonia> colonias = this.getColonias();
        for (Colonia colonia : colonias) {
            if (colonia.getCodigoPostal() == codigoPostal) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }

        return coloniaId;
    }
    
    public List<SelectItem> getSelectItems(){
        final List<SelectItem> selectItems = new ArrayList<>();
        final List<Colonia> colonias = this.getColonias();
        colonias.forEach(colonia -> {
            SelectItem item = new SelectItem(colonia.getColoniaId(), colonia.getNombre());
            selectItems.add(item);
        });
        return selectItems;
    }
}
