# SelenideHomeworks

Homework project with Selenide, TestNG, Allure and POM structure.

## Structure

- `pages` - page objects and selectors
- `steps` - reusable test steps with `@Step`
- `tests` - TestNG tests with Allure annotations

## Run tests

```bash
mvn clean test
```

## Allure report

```bash
allure serve target/allure-results
```
