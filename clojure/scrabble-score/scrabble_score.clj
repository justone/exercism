(ns scrabble-score
  (:require [clojure.string :refer [lower-case]]))

; create map of char to score {"a" 1 "b" 3 ...}
(def charscores
  (->> {"aeioulnrst" 1
        "dg" 2 "bcmp" 3
        "fhvwy" 4 "k" 5
        "jx" 8 "qz" 10
        }
       (mapcat (fn [[s v]] (map #(-> {(str %) v}) s)))
       (into {})))

(defn score-letter [letter]
  (charscores (lower-case letter)))

(defn score-word [word]
  (reduce + (map score-letter word)))
