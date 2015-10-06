(ns for)

(def data
  [["root" "x" 0]
   ["domain.com" "x" 3000]
   ["nate" "x" 3001]
   ["domain2.com" "x" 3002]])

(for [user data
      :when (>= (get user 2) 3000)
      :when (re-matches #".*\..*" (first user))]
  (first user))
