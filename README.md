# Allure-helper
[![Build Status](https://travis-ci.org/sbtqa/allure-helper.svg?branch=master)](https://travis-ci.org/sbtqa/allure-helper) [![GitHub release](https://img.shields.io/github/release/sbtqa/allure-helper.svg?style=flat-square)](https://github.com/sbtqa/allure-helper/releases) [![Maven Central](https://img.shields.io/maven-central/v/ru.sbtqa.tag/allure-helper.svg)](https://mvnrepository.com/artifact/ru.sbtqa.tag/allure-helper)

Allure-helper - небольшая библиотека, которая упрощает работу с отчетом Allure во время выполнения тестов.
Содержит в себе следующие классы и методы:  
* **ParamsHelper** - класс для работы с вложениями:
   * **addParam** - метод позволяет добавить параметр в шаг отчета
   * **addAttachment** - метод позволяет добавить вложение в шаг отчета
* **AllureNonCriticalFailure** - класс для работы с не критичными ошибками при выполнении теста.
* **OnFailureScheduler** - класс выполняющийся после падения теста

### Контакты
Нашли ошибку или появились вопросы? [Проверьте](https://github.com/sbtqa/allure-helper/issues) нет ли уже созданных issue, если нет то создайте [новое](https://github.com/sbtqa/allure-helper/issues/new)!

### Лицензия 
Allure-helper выпущен под лицензией Apache 2.0. [Подробности](https://github.com/sbtqa/allure-helper/blob/master/LICENSE).