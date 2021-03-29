package simulator;

public class IdList {
  private int[] vehiclesIds;

  public int[] getVehiclesIds() {
    return vehiclesIds;
  }

  /**
   * This function adds a id to the list
   * 
   * @param Id id to check if it's in the list
   * @return true or false, acording of function succes
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
   * This function checks whether the array contains the id
   * 
   * @param Id id to search on array
   * @return true or false, acording of function succes
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
   * This function search the id on list of vehicles ids
   * 
   * @param Id id to search on array
   * @return the index of wanted id
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
   * This function remove the id entered in the parameter
   * 
   * @param Id id to search on array
   * @return true or false, acording of function succes
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
