package kata7v5.view;

import kata7v5.model.Histogram;

public interface HistogramDisplay {
    public Histogram histogram();
    public void show(Histogram histogram);
}
