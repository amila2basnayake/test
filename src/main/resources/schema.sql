create memory table if not exists city
(
    ID           INT PRIMARY KEY AUTO_INCREMENT,
    NAME         VARCHAR(255),
    COUNTRY_CODE VARCHAR(3)
);


create memory table if not exists travel
(
    ID          INT PRIMARY KEY AUTO_INCREMENT,
    CITY        INT,
    TRAVEL_DATE TIMESTAMP default NOW()
);


ALTER TABLE travel
    ADD CONSTRAINT fk_travel_city FOREIGN KEY (CITY) REFERENCES city (ID);


create memory table if not exists weather_forecast
(
    ID                 INT PRIMARY KEY AUTO_INCREMENT,
    TEMPERATURE        DOUBLE,
    TRAVEL             INT,
    CITY               INT,
    CLOUDS             INT,
    FORECAST_DATE_TIME TIMESTAMP
);


ALTER TABLE weather_forecast
    ADD CONSTRAINT fk_travel_weather_forecast FOREIGN KEY (TRAVEL) REFERENCES travel (ID);

ALTER TABLE weather_forecast
    ADD CONSTRAINT fk_city_weather_forecast FOREIGN KEY (CITY) REFERENCES city (ID);


