#! /bin/bash
sass --style=expanded "./src/main/resources/static/scss/main.scss" "./src/main/resources/static/css/style.css";
sass --style=compressed "./target/classes/static/scss/main.scss" "./target/classes/static/css/style.css";
rm -r "./target/classes/static/scss";