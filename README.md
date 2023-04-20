### REST-сервис для хранения данных о спортивных командах.

##### Тесты проводились в Postman (https://www.postman.com/downloads/)
<br><br>
 Нужно создать postgresql базу данных - sport. Так же есть файл для создания в проекте в папке "create_db_helper"<br>
юзер - root c паролем root (либо сделать изменения в application.properties под себя)
<br><br>
 Локальный сервер: http://localhost:8080
<br>

#### Методы REST-сервиса

<table>
    <thead>
        <tr>
            <th>HTTP</th>
            <th>Методы API</th>
            <th>Body(JSON) / Параметры</th>
            <th>Описание</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan=4>GET</td>
            <td rowspan=4>/sport/teams</td>
            <td rowspan=4>
            </td>
            <td rowspan=4>
            Получить информацию<br> о всех командах 
            <br><br>
            </td>
        </tr>
    </tbody>
        <tbody>
        <tr>
            <td rowspan=4>GET</td>
            <td rowspan=4>/sport/teams//sport-type</td>
            <td rowspan=4>
            В Postman: Params<br><br>
            key - type<br>
            Value - Soccer/Hockey и т.д.<br><br>
            </td>
            <td rowspan=4>
            Показать все команды,<br> отфильтрованные по виду спорта.
            </td>
        </tr>
    </tbody>
        <tbody>
        <tr>
            <td rowspan=4>GET</td>
            <td rowspan=4>/sport/teams/create-dates</td>
            <td rowspan=4>
            В Postman: Params<br><br>
            key - date-one
            Value - дата в формате "yyyy-MM-dd"<br><br>
            key - date-two<br>
            Value - дата в формате "yyyy-MM-dd"
            </td>
            <td rowspan=4>
            Показать все команды,<br> отфильтрованные в диапазоне<br> между двумя датами<br>
            </td>
        </tr>
    </tbody>
        <tbody>
        <tr>
            <td rowspan=4>DELETE</td>
            <td rowspan=4>/sport//teams/{teamId}</td>
            <td rowspan=4>
            </td>
            <td rowspan=4>
            Под нож команду <br>вместе с игроками!
             <br><br>
            </td>
        </tr>
    </tbody>
        <tbody>
        <tr>
            <td rowspan=4>POST</td>
            <td rowspan=4>/sport/teams</td>
            <td rowspan=4>
            В Postman: body -> raw ->JSON<br>
                {<br>
                "name": "Real",<br>
                "sportType": "Soccer",<br>
                "createDate": "1902-03-06"<br>
                }<br>
            </td>
            <td rowspan=4>
            Добавить команду,<br>
            ввод JSON без id
            </td>
        </tr>
    </tbody>
    <tbody>
            <tr>
                <td rowspan=4>PUT</td>
                <td rowspan=4>/sport/teams</td>
                <td rowspan=4>
                В Postman: body -> raw ->JSON<br>
                    {<br>
                    "id": 2,<br>
                    "name": "Real",<br>
                    "sportType": "Soccer",<br>
                    "createDate": "1902-03-06"<br>
                    }<br>
                </td>
                <td rowspan=4>
                Изменить данные команды<br>Уже с id
                </td>
            </tr>
    </tbody>
    <tbody>
        <tr>
            <td rowspan=4>GET</td>
            <td rowspan=4>/sport/players/{teamId}</td>
            <td rowspan=4>
            </td>
            <td rowspan=4>
            Получить всех игроков<br> в конкретной команде<br>по teamId
            </td>
        </tr>
    </tbody>
    <tbody>
            <tr>
                <td rowspan=4>GET</td>
                <td rowspan=4>/sport/players/{teamId}/positions</td>
                <td rowspan=4>
                 В Postman: Params<br><br>
                 key - position<br>
                 Value - Goalkeeper/Defender и т.д.<br>
                </td>
                <td rowspan=4>
                Показать игроков<br> конкретной команды,<br> фильтр по позиции<br>в команде<br>
                </td>
            </tr>
    </tbody>
    <tbody>
            <tr>
                <td rowspan=4>POST</td>
                <td rowspan=4>/sport/players/{teamId}</td>
                <td rowspan=4>
                В Postman: body -> raw ->JSON
                <br>
                { <br>
                    "name": "Mattia",<br>
                    "surname": "Perin",<br>
                    "patronymic": null,<br>
                    "birthday": "1992-11-10",<br>
                    "position": "Goalkeeper"<br>
                }<br>
                </td>
                <td rowspan=4>
                Добавим игрока <br>в конкретную команду
                </td>
            </tr>
    </tbody>
    <tbody>
        <tr>
            <td rowspan=4>DELETE</td>
            <td rowspan=4>/sport/players/{playerId}</td>
            <td rowspan=4>
            </td>
            <td rowspan=4>
            Под нож игрока в команде
            </td>
        </tr>
    </tbody>
        <tbody>
        <tr>
            <td rowspan=4>PUT</td>
            <td rowspan=4>/sport/players/{teamId}</td>
            <td rowspan=4>
            В Postman: body -> raw ->JSON
                            <br>
            {<br>
            "id": 1,<br>
            "name": "Mattia",<br>
            "surname": "Perin",<br>
            "patronymic": null,<br>
            "birthday": "1992-11-10",<br>
            "position": "Goalkeeper"<br>
            }<br>
            </td>
            <td rowspan=4>
            Изменение игрока <br>в конкретной команде.<br>
            Изменяем данные кроме id
            </td>
        </tr>
    </tbody>
        <tbody>
        <tr>
            <td rowspan=4>PATCH</td>
            <td rowspan=4>/sport/players/{playerId}</td>
            <td rowspan=4>
            В Postman: Params<br><br>
             key - newTeamId<br>
             Value - 1/2/3 и т.д.<br>
            </td>
            <td rowspan=4>
            перекинуть игрока<br>
             из одной тимы в другую<br>
              по id игрока <br>
              в id новой тимы<br>
            </td>
        </tr>
    </tbody>
</table>
