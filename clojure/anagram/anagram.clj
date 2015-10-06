(ns anagram
  (:require [clojure.string :as str]))

(defn anagram?
  [a b]
  (let [la (str/lower-case a)
        lb (str/lower-case b)]
    (and (not= la lb) (= (sort la) (sort lb)))))

(defn anagrams-for
  [needle haystack]
  (let [needle-anagram? (partial anagram? needle)]
    (filter needle-anagram? haystack)))
