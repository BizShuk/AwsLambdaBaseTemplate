package aws.lambda.base.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.amazonaws.services.lambda.runtime.Context;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaConfig {
    static String product;
    static Context lambdaCtx; // From Lambda handleRequest context
    static LambdaConfig config;
    static List<String> secretList = new ArrayList<>();
    static List<Components> selectedComponents;

    public static enum Components {

    }

    LambdaConfig() {
    }

    public static void init(Context ctx, String product, String[] secretList,
            Components[] selectedComponents) {
        log.info("Product: {}, SecretList: {}, Loaded Components: {}", product, secretList,
                selectedComponents);

        LambdaConfig.lambdaCtx = ctx;
        if (LambdaConfig.config != null)
            return;

        LambdaConfig.product = product;
        LambdaConfig.secretList = Arrays.asList(secretList);
        if (selectedComponents != null)
            LambdaConfig.selectedComponents = Arrays.asList(selectedComponents);
        config = new LambdaConfig();

    }
}
