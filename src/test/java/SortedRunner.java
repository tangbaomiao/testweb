import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tangyaru on 2018/1/17.
 */
public class SortedRunner extends BlockJUnit4ClassRunner {
    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @param klass
     * @throws InitializationError if the test class is malformed.
     *
     */
    public SortedRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> list = super.computeTestMethods();
        Collections.sort(list,new Comparator<FrameworkMethod>() {
            public int compare(FrameworkMethod f1, FrameworkMethod f2) {
                Index index1 = f1.getAnnotation(Index.class);
                Index index2 = f2.getAnnotation(Index.class);
                if (index1 == null || index2 == null)
                    return -1;
                return index1.value() - index2.value();
            }
        });
        return list;
    }

//    @Override
//    protected List<FrameworkMethod> computeTestMethods() {
//        List<FrameworkMethod> list = super.computeTestMethods();
//        Collections.sort(list, new Comparator<FrameworkMethod>() {
//            public int compare(FrameworkMethod o1, FrameworkMethod o2) {
//                Index o11 = o1.getAnnotation(Index.class);
//                Index o22 = o2.getAnnotation(Index.class);
//                if (o11 == null || o22 == null)
//                    return 0;
//                return o11.value() - o22.value();
//            }
//        });
//        return list;
//    }
}
