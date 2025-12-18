#!/bin/bash
echo "=========================================="
echo "||  Building Warehouse System...        ||"
echo "=========================================="
echo ""

chmod +x mvnw

./mvnw clean compile

if [ $? -ne 0 ]; then
    echo "Build failed!"
    exit 1
fi

echo ""
echo "=========================================="
echo "||  Running Application...              ||"
echo "=========================================="
echo ""

./mvnw exec:java -Dexec.mainClass="itpu.uz.alibek.Main"

echo ""
echo "=========================================="
echo "||  Application finished                ||"
echo "=========================================="
