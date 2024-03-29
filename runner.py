# runner.py

import os
import sys

# TODO build this out to download external dependencies (buildSrc/common)

# Commands
build = "./gradlew clean build --refresh-dependencies -x test > src/main/java/com/rumpus/admin/log/build.log"
buildXlint = "./gradlew clean build --refresh-dependencies -x test -Xlint:unchecked > src/main/java/com/rumpus/admin/log/build.log"
buildDebug = "./gradlew clean build --refresh-dependencies --debug -x test > src/main/java/com/rumpus/admin/log/build.log"
buildTest = "./gradlew clean build --refresh-dependencies > src/main/java/com/rumpus/admin/log/build.log"
buildTestInfo = "./gradlew clean build --info --refresh-dependencies > src/main/java/com/rumpus/admin/log/build.log"
buildTestDebug = "./gradlew clean build --debug --refresh-dependencies > src/main/java/com/rumpus/admin/log/build.log"
test = "./gradlew test > src/test/java/com/rumpus/admin/log/test.log"
run = "./gradlew bootRun &> src/main/java/com/rumpus/admin/log/spring.log"
runDebug = "./gradlew bootRun --debug > src/main/java/com/rumpus/admin/log/spring.log"

def commands():
    pass

if __name__ == '__main__':
    print(f"Arguments count: {len(sys.argv) - 1}")
    for i, arg in enumerate(sys.argv):
        if i == 0:
            continue
        print(f"{i:>6}: {arg}")
        if arg == "build":
            os.system(build)
        elif arg == "buildXlint":
            os.system(buildXlint)
        elif arg == "buildTest":
            os.system(buildTest)
        elif arg == "buildDebug":
            os.system(buildDebug)
        elif arg == "buildTestInfo":
            os.system(buildTestInfo)
        elif arg == "buildTestDebug":
            os.system(buildTestDebug)
        elif arg == "test":
            os.system(test)
        elif arg == "run":
            os.system(run)
        elif arg == "runDebug":
            os.system(runDebug)
        elif arg == "locust_test":
            os.system(locust_test)
        elif arg == "locust_version":
            os.system(locust_version)
        else:
            print("Error: bad argument")
        