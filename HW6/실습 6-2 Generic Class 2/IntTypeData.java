public class IntTypeData extends SpecificTypeData<Integer>{
    Integer data;
    Integer sum;

    public IntTypeData(Integer data){
        super(data);
        this.data = data;
    }

    @Override
    public Integer getData(){
        return sum;
    }

    @Override
    public void addData(Integer a){
        sum = a + data;
    }
}
