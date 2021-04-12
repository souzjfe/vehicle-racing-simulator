
//Trabalho dos alunos Jefeson Souza e Luiz Henrique Vicari

//A ideia dessa classe e substitur o uso de ArrayList

package simulator;

public class IdList {
  private int[] vehiclesIds;

  public int[] getVehiclesIds() {
    return vehiclesIds;
  }

  /**
   * This method adds a id to the list
   * Adiciona um id na lista
   * 
   * @param Id id to check if it's in the list (checa se o id já está n alista)
   * @return true or false, acording of function succes (true ou false se funcionou ou não)
   */
  public boolean add(int Id) {
    if (this.vehiclesIds == null) {
      this.vehiclesIds = new int[1];
      this.vehiclesIds[0] = Id;
      return true;
    } else {
      int[] newListId = new int[this.vehiclesIds.length + 1];
      int i;
      for (i = 0; i < this.vehiclesIds.length; i++) {
        newListId[i] = this.vehiclesIds[i];
      }
      if (i < 20) {
        newListId[i] = Id;
        this.vehiclesIds = newListId;
        return true;
      } else
        return false;
    }
  }

  /**
   * This method checks whether the array contains the id
   * Verifica se o array contém o id
   * 
   * @param Id id to search on array (id que será buscado no array)
   * @return true or false, acording of function succes (true ou false se funcionou ou não)
   */
  public boolean contains(int Id) {
    if (this.vehiclesIds != null) {

      for (int vehicleId : this.vehiclesIds) {
        if (Id == vehicleId) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * This method search the id on list of vehicles ids
   * Procura o id na lista de ids
   * 
   * @param Id id to search on array (id que será buscado)
   * @return the index of wanted id (a posição do id)
   */
  public int indexOf(int Id) {
    for (int i = 0; i < this.vehiclesIds.length; i++) {
      if (Id == this.vehiclesIds[i]) {
        return i;
      }
    }
    return -1;

  }

  /**
   * This method remove the id entered in the parameter
   * Remove um id no array
   * 
   * @param Id id to search on array (id que será removido)
   * @return true or false, acording of function succes (true ou false se funcionou ou não)
   */
  public boolean remove(int Id) {
    if (this.vehiclesIds == null) {
      return false;
    } else {
      int index = indexOf(Id);
      if (index >= 0) {
        int[] newListId = new int[this.vehiclesIds.length - 1];
        int i;
        for (i = 0; i < index; i++) {
          newListId[i] = this.vehiclesIds[i];
        }
        for (; index < this.vehiclesIds.length - 1; index++) {
          newListId[index] = this.vehiclesIds[index + 1];
        }
        this.vehiclesIds = newListId;
        return true;
      } else {
        return false;
      }
    }

  }
}
