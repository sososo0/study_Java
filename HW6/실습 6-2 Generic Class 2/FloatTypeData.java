public class FloatTypeData extends SpecificTypeData<Float>{
    Float data;
    Float sum;

    public FloatTypeData(Float data){
        super(data);
        this.data = data;
    }

    @Override
    public Float getData(){
        return sum;
    }

    @Override
    public void addData(Float a){
        sum = a+data;
    }
}