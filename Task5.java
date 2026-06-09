import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task5 {

    private static final Logger logger =
            LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {

        try {

            if (doc == null) {
                // FIX: Expected validation failure should be logged as warning
                logger.warn("Validation failed: Document is null");
                return new ValidationResult(false);
            }

            String content = doc.extractContent();

            if (content == null || content.isEmpty()) {
                // FIX: Expected validation failure should be logged as warning
                logger.warn("Validation failed: Empty content");
                return new ValidationResult(false);
            }

            return runValidationRules(content);

        } catch (Exception e) {

            // FIX: Use logger instead of printStackTrace
            logger.error("Unexpected error during validation", e);

            // FIX: Avoid returning null
            return new ValidationResult(false);
        }
    }

    public void validateBatch(List<Document> docs) {

        for (Document doc : docs) {

            try {

                ValidationResult r = validate(doc);

                // FIX: Check for null before calling isValid()
                if (r != null && r.isValid()) {
                    saveResult(r);
                }

            } catch (Exception e) {

                // FIX: Log exception instead of swallowing it
                logger.error("Error while validating document", e);
            }
        }
    }

    private ValidationResult runValidationRules(String content) {
        return null;
    }

    private void saveResult(ValidationResult result) {
    }
}
