package cucumberDatatableMapping;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;

public class CucumberDataTableTypeConfigurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {

        registry.defineDataTableType(new DataTableType(OfficeLocationParameters.class, new TableEntryTransformer<OfficeLocationParameters>() {
            @Override
            public OfficeLocationParameters transform(Map<String, String> entry) {
                return new OfficeLocationParameters(entry.get("City"),entry.get("Address"),entry.get("Phone Number"));
            }
        }));
    }
}
