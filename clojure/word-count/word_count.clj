(ns word-count
  (:require [clojure.string :as str]))

(defn word-count
  [in]
  (frequencies (re-seq #"\w+" (str/lower-case in))))

; (def word-count #(frequencies (re-seq #"\w+" (str/lower-case %))))
