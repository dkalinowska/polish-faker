package service;

import java.util.List;
public interface YamlBased {
    List<?> handleYaml(String fileName, String... keys);
}
