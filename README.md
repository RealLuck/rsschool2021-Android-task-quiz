# rsschool2021-Android-task-quiz
Rolling Scope School - Android 2021 - Stage 1 - Task 2 - Quiz

:point_up: Во втором практическом задании создадим приложение-квиз, с возможностью шарить результат

<img alt="quiz app" src="/img/quiz.gif" width="250" height="500" />

[или см. демо-видео на YouTube](https://www.youtube.com/watch?v=jG3W5w6pfuw)

## Описание задания

Приложение состоит из нескольких экранов с вопросами и экрана с результатом. На экране с вопросом:

- текст вопроса
- варианты ответов - можно оформить как radio buttons или как-то по-другому, на ваше усмотрение. Основное требование: пользователь должен понимать, какой вариант ответа он выбрал. Давайте для простоты установим, что только один вариант ответа правильный. 
- кнопка `Next` - ведёт на следующий экран с вопросом. На последнем экране с вопросом меняется на `Submit`. Нажатие на `Submit` открывает экран с результатом квиза. Кнопки `Next` и `Submit` недоступны, если вариант ответа не выбран.
- кнопка `Previous` - ведёт на предыдущий экран с вопросом. Недоступна для первого экрана с вопросом. 

При переходах между экранами через кнопки `Previous` или `Next` уже выбранные варианты ответов сохраняются. Варианты ответов могут быть изменены до нажатия `Submit`. На toolbar доступна кнопка `<`, поведение которой аналогично поведению `Previous`.

На экране с результатом:

- текст результата, отображающий информацию о количестве верных ответов. Например, "Результат: 40 %" или "Результат: 5 из 5" - тут на ваше усмотрение.
- кнопка `Share` - возможность пошарить результат квиза. Например, через email. При этом сгенерированный текст должен содержать: результат квиза, список вопросов с порядковым номером вопроса и выбранным пользователем вариантом ответа.
- кнопка `Back` - сбрасывает результаты квиза. Перенаправляет пользователя на начальный экран.
- кнопка `Exit` - зыкрывает приложение

📱 Требования к дизайну:

- смотрите пример возможного дизайна выше на видео. Вид кнопок, вопросов, вариантов, цветовых схем - все на ваше усмотрение. В layouts в этом репозитории дан возможный layout фрагмента с вопросом. Можно оставить как есть или сделать свой вариант.
- Каждому отдельному экрану с вопросом должна соответствовать своя тема (Theme). В репозитории есть возможные варианты цветов и 5 тем. Можно оставить как есть или изменить на свой вкус.

💻 Требования к коду:

- в прошлый раз мы получали ссылки на view через `findViewById()`. На сегодня это не самый лучший вариант. Давайте использовать [view binding](https://developer.android.com/topic/libraries/view-binding#kotlin) 
- Kotlin

Другие требования:
- минимальное число вопросов 5
- минимальное число вариантов ответов 5

## Cross-checking

- Изучите требования к <a href="https://docs.rs.school/#/cross-check-flow?id=cross-check">cross-check</a>
- Форму для оценки задания по критериям ищите <a href="https://ziginsider.github.io/checklist/index.html">здесь</a>

Успехов! 🤞
