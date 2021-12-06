(ns advent-of-code-2021.core
  (:use [clojure.string :as str :only (split-lines split trim)]))

(def input-dir "input")
(def sample-input-dir "test/advent_of_code_2021/input")

(defn bin->dec
  "turn a string of binary into a decimal integer"
  [binary]
  (Integer/parseInt binary 2))

(defn strings->ints
  "turn a list of strings which look like numbers into a list of actual numbers"
  [lines]
  (map #(Integer/parseInt %) lines))

(defn load-input-raw
  "the given file as a single string"
  [file]
  (slurp file))

(defn load-input-lines
  "the given file as a seq of lines"
  [file]
  (str/split-lines (load-input-raw file)))

(defn load-input-ints
  "the given file as a seq of integers"
  [file]
  (strings->ints (load-input-lines file)))

(defn load-input-blocks
  [file]
   (str/split (load-input-raw file) #"\n\n"))

(defn fields
  "break a regex-delimeter string into an array of fields"
  ([string]
   (fields string #" +"))
  ([string sep]
   (str/split (str/trim string) sep)))

(defn int-fields
  "break a  string into an array of fields, which are ints"
  ([string]
   (strings->ints (fields string #" +")) )
  ([string, sep]
   (strings->ints (fields string sep))))

(defn input-file
  "the path to the input file for the given day"
  ([day]
   (str input-dir "/" day))
  ([day part]
   (str input-dir "/" day part)))

(defn sample-input-file
  "the path to the example input file for the given day"
  ([day]
   (str sample-input-dir "/" day))
  ([day part]
   (str sample-input-dir "/" day part)))

(defn solve-all
  [day fn-load-input fn-solve-01 fn-solve-02]
  (println "day" day "1/2:" (fn-solve-01 (fn-load-input (input-file day))))
  (println "day" day "2/2:" (fn-solve-02 (fn-load-input (input-file day)))))
