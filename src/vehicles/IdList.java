package vehicles;

public class IdList {
  private int amountIds = 0;
  private int[] vehiclesIds = new int[20];

  private void setAmountIds(int amountIds) {
    this.amountIds = amountIds;
  }

  public int[] getVehiclesIds() {
    return vehiclesIds;
  }

  public void add(int Id) {
    if (amountIds < 20) {
      this.vehiclesIds[amountIds] = Id;
      setAmountIds(amountIds + 1);
    }
  }

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
   * @param Id id for search on array 
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

  public void remove(int Id) {
    int index = indexOf(Id);

    for (; index < vehiclesIds.length; index++) {
      vehiclesIds[index] = vehiclesIds[index + 1];
    }

  }
}
