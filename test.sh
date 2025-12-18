#!/bin/bash

echo "=========================================="
echo "||  Running Tests...                    ||"
echo "=========================================="
echo ""

chmod +x mvnw

./mvnw test # Maven command for tests

if [ $? -eq 0 ]; then
    echo ""
    echo "=========================================="
    echo "  All tests passed!"
    echo "=========================================="
else
    echo ""
    echo "=========================================="
    echo "  Some tests failed!"
    echo "=========================================="
    exit 1
fi
