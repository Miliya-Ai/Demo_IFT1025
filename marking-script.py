import os
import subprocess
import shutil
import re

base_directory = "/mnt/c/Users/Famelis/OneDrive - Universite de Montreal/cours/IFT1025-Programmation-2/2023-2A/devoirs/D1/"

submissions_directory = base_directory+"D1-submissions"
crucible_directory = base_directory+"D1-marking/crucible"

test_cases_file = base_directory+"D1-marking/Autograder.java"

compile_ex = "javac -cp /usr/share/java/junit4.jar:. Autograder.java Exercice1.java"
compile_all = "javac -cp /usr/share/java/junit4.jar:. Autograder.java Exercice1.java"
do_tests="java -cp /usr/share/java/junit4.jar:/usr/share/java/hamcrest-core.jar:. org.junit.runner.JUnitCore Autograder"

exercise_source = base_directory+"D1-marking/Exercice.java"
compiled_exercise = base_directory+"D1-marking/Exercice.class"

results_file = base_directory+"D1-marking/results.csv"

failures_pattern = r"Failures: (\d+)"

# prepare the crucible
shutil.copy(test_cases_file,crucible_directory)
os.chdir(crucible_directory)

with open(results_file, 'w') as r:
    pass

for root, dirs, files in os.walk(submissions_directory):
    for file in files:
        if file.endswith(".java"):
            
            # re-initialize the problem flags
            compilation_error=False
            tests_failed=False
            badly_named_file=False
            n_tests_failed=0
            
            grade=5

            # find the files and student info
            full_file_name=os.path.join(root, file)
            parts = full_file_name.split("/")
            student_name = parts[-2].split("_")[0]
            student_id = parts[-2].split("_")[1]
            submission_file_name = parts[-1]
            file_name_with_student_path = "/".join(parts[-2:])


            # clean the crucible
            try:
                os.remove(exercise_source)
                os.remove(compiled_exercise)
            except FileNotFoundError:
                pass

            # put the student submission in the crucible
            if not submission_file_name == "Exercice1.java":
                # print("BADLY NAMED FILE ", file_name_with_student_path)
                badly_named_file=True
            shutil.copy(full_file_name,crucible_directory)

            # compile only their code
            try:
                compilation_output=subprocess.check_output(compile_ex, shell=True, stderr=subprocess.STDOUT, text=True)
            except subprocess.CalledProcessError as e:
                # Compilation error!
                #print("command '{}' return with error (code {}): {}".format(e.cmd, e.returncode, e.output))
                compilation_error=True

            if not compilation_error:
                # compile their code with my tests
                try:
                    compilation_output_with_tests=subprocess.check_output(compile_all, shell=True, stderr=subprocess.STDOUT, text=True)
                except subprocess.CalledProcessError as e:
                    # Compilation error!
                    #print("command '{}' return with error (code {}): {}".format(e.cmd, e.returncode, e.output)) 
                    print("This should not happen!")
                    compilation_error=True

                # run the tests
                try:
                    tests_output=subprocess.check_output(do_tests, shell=True, stderr=subprocess.STDOUT, text=True)
                except subprocess.CalledProcessError as e:
                    # Some test failed!
                    # print("command '{}' return with error (code {}): {}".format(e.cmd, e.returncode, e.output))
                    tests_failed=True
                    match = re.search(failures_pattern, e.output)
                    if match:
                        n_tests_failed=int(match.group(1))
                        # print(student_name+" failed "+n_tests_failed+" tests")

            result_code = "OK"
            if compilation_error:
                result_code="CE"
                grade = 0
            if tests_failed:
                result_code="F"+str(n_tests_failed)
                grade = grade - n_tests_failed
            if badly_named_file:
                # Since the badly named file does not break our script, we are forgiving and not giving a 0, but we still deduct 1
                result_code="BF"
                grade = grade - 1

            with open(results_file, 'a') as r:
                r.write(",".join([student_name, student_id, file_name_with_student_path, result_code, str(grade)]) + "\n" )

