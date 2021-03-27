package simulator;

public class IdList {
  private int amountIds = 0;
  private int[] vehiclesIds = new int[20];

  private void setAmountIds(int amountIds) {
    this.amountIds = amountIds;
  }

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
    if (amountIds < 20) {
      this.vehiclesIds[amountIds] = Id;
      setAmountIds(amountIds + 1);
      return true;
    }
    return false;
  }

  /**
   * This function checks whether the array contains the id
   * 
   * @param Id id to search on array
   * @return true or false, acording of function succes
   */
  public boolean contains(int Id) {
    for (int i = 0; i < this.vehiclesIds.length; i++) {
      if (Id == this.vehiclesIds[i]) {
        return true;
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
    int index = indexOf(Id);
    if (index >= 0) {

      this.vehiclesIds[index] = 0;
      return true;
    } else {
      return false;
    }

  }
}
