package pageObjects;

import com.google.common.base.Throwables;
import org.openqa.selenium.WebDriver;

public final class PageProviders {

    private PageProviders() {
    }

    @Deprecated // use PageObjectClassName::new instead
    public static <T extends AbstractBasePage> PageProvider<T> providesPage(final Class<T> clazz) {
        return new ReflectionPageProvider<T>(clazz);
    }

    private static final class ReflectionPageProvider<T extends AbstractBasePage> implements PageProvider<T> {

        private final Class<T> clazz;

        private ReflectionPageProvider(Class<T> clazz) {
            this.clazz = clazz;
        }

        @Override
        public T getPage(WebDriver driver) {
            try {
                return clazz.getConstructor(WebDriver.class).newInstance(driver);
            } catch (Exception e) {
                throw Throwables.propagate(e);
            }
        }
    }
}
