(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn transform
  [input]
  (->> input
       (map #(interleave (map lower-case (second %)) (repeat (first %))))
       flatten
       (apply hash-map)))
