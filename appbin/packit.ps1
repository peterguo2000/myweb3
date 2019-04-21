cp ../dbwatcher-db-config/build/libs/dbwatcher-db-config-0.0.1-SNAPSHOT.jar ./dbwatcher
cp ../dbwatcher-api/build/libs/dbwatcher-1.0.0-SNAPSHOT.jar ./dbwatcher
cp ./startit.ps1 ./dbwatcher
zip dbwatcher.zip -r ./dbwatcher
