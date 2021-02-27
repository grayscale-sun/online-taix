package service;

public class DisruptorEvent{

    private Long value;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DisruptorService{" +
                "value=" + value +
                '}';
    }
}
