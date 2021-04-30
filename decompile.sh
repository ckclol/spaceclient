#!/bin/bash
cd "$(dirname "$0")"
python runtime/decompile.py "$@"
