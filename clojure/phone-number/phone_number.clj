(ns phone-number
  (:require [clojure.string :as str]))

(defn number
  [n]
  (let [cleaned (str/replace n #"[^0-9]" "")
        length  (count cleaned)]
    (cond
      (= length 10) cleaned
      (and (= length 11) (= (first cleaned) \1)) (subs cleaned 1)
      :else "0000000000")))

(defn area-code
  [n]
  (subs (number n) 0 3))

(defn pretty-print
  [n]
  (let [cleaned (number n)]
    (format "(%s) %s-%s",
            (subs cleaned 0 3)
            (subs cleaned 3 6)
            (subs cleaned 6))))
