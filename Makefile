.PHONY: test progress

# make test            every exercise
# make test EX=13.2    one exercise
# make test EX=13      one chapter
test:
	./run_tests.sh $(EX)

progress:
	python3 tools/progress.py
