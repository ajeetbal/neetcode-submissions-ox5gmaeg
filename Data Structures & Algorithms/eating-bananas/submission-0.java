class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
		int r = 0;

		for (int i : piles) {
			r = Math.max(i, r);
		}

		int result = r;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (canFinish(mid, h, piles)) {
				result = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		return result;
    }

    private boolean canFinish(int k, int h, int[] piles) {
		int totalHours = 0;
		for (int pile : piles) {
			totalHours += (pile + k - 1) / k;
		}

		return totalHours > h ? false : true;
	}
}
